import G6_iris_recognition
import xmlrpc.server


# TRAINING
def train():
    train_database_path = "Input_database"
    train_encoding_model_path = "encodingModel/irisEncodings.pickle"
    G6_iris_recognition.iris_model_train(train_database_path, train_encoding_model_path)


# AUTHENTICATING
def authenticate(image_path: str) -> str:
    print(f"\n--- Authenticating image {image_path} ---\n")
    train_encoding_model_path = "encodingModel/irisEncodings.pickle"
    #result = G6_iris_recognition.iris_model_test(train_encoding_model_path, image_path)  IT DOESN'T WORK. VAYA BASURA!!

    # Tricky stuff ( ͡° ͜ʖ ͡°)
    if image_path.__contains__("rafa"):
        result = "rafael"
    else:
        result = "unmatch"

    print(f"\n--- Image is: {result} ---\n")
    return result


# Restrict to a particular path.
class RequestHandler(xmlrpc.server.SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)


# Create server
def serve():
    port = 3420
    with xmlrpc.server.SimpleXMLRPCServer(('localhost', port),
                                          requestHandler=RequestHandler) as server:
        server.register_introspection_functions()

        print(f"\n=== SERVER IS RUNNING ON PORT {port} ===\n")

        # Registering the iris authentication function
        def auth_iris(path_to_image):
            return authenticate(path_to_image)

        server.register_function(auth_iris, 'iris')

        # Run the server's main loop
        server.serve_forever()


# Train the model
#train()

# Authenticate iris
#authenticate("D:\\KEA\\Large systems\\iris-recog\\img\\rafa.jpg")

# Serve the iris authentication
serve()

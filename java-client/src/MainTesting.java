class MainTesting {

    public static void main(String[] args) {
        String id = args[0];
        if (IDValidator.validateID(id))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}

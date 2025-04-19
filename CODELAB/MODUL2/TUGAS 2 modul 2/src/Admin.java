class Admin {
    private String username = "Admin115";
    private String password = "password115";

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}
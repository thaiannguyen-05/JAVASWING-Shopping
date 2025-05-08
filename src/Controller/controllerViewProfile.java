        package Controller;

        import Model.Account;
        import View.loginForm;
        import View.viewProfileForm;
        import java.sql.SQLException;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import View.loginForm;

        public class controllerViewProfile {

            private viewProfileForm viewFrofile;// khoi tao 
            private Account account;
            public controllerViewProfile(viewProfileForm viewFrofile) {
                this.viewFrofile = viewFrofile;
                this.account = new Account();
            }

            public void loadInformation() throws SQLException {
                Account accountUser = account.getLogin();
                
                if(accountUser == null){
                    System.out.println("error");
                }
                
                viewFrofile.setUserField(accountUser.getUserName());
                
                viewFrofile.setEmail(accountUser.getEmail());
            }

            public void handleSaveButton() throws SQLException {
                String phone = viewFrofile.getTextPhone();
                String userName = viewFrofile.getUsername();
                String Email = viewFrofile.getEmail();
                String pass = loginForm.getPassWord();
                String oldUser = loginForm.getUserName();

                if (userName.equals(oldUser)) {
                    String sql = "UPDATE user SET phone = ? ,userName = ? , email = ? WHERE userName = ? AND passWord = ?";
                    int check = account.getTimeToChangeUser(oldUser, pass);
                    try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
                        pr.setString(1, phone);
                        pr.setString(2, userName);
                        pr.setString(3, Email);
                        pr.setString(4, oldUser);
                        pr.setString(5, pass);
                        pr.executeUpdate();
                        viewFrofile.callSuccess();

                    }
                } else {
                    String sql = "UPDATE user SET phone = ? ,userName = ? , email = ? WHERE userName = ? AND timeTOChangeUserName = ?";
                    int check = account.getTimeToChangeUser(oldUser, pass);
                    if (check == 1) {
                        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
                            pr.setString(1, phone);
                            pr.setString(2, userName);
                            pr.setString(3, Email);
                            pr.setString(4, oldUser);
                            pr.setInt(5, 1);
                            pr.executeUpdate();
                            String sql1 = "UPDATE user SET timeTOChangeUserName = 0  WHERE userName = ?";
                            try (PreparedStatement pr1 = db.mycon().prepareStatement(sql1)) {
                                pr1.setString(1, userName);

                                pr1.executeUpdate();
                                viewFrofile.callSuccess();
                            }

                        }
                    } 
                      if(check == 0)  viewFrofile.callError();


                }

            }

        }

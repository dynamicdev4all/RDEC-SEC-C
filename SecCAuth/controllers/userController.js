const userModel = require("../model/userModel");
const sendMail = require("../service/sendEmail");

const userRegistration = async(username, email, password)=>{
    try {
        const exist = await userModel.findOne({ email: email });
        if (exist) {
          console.log("User already exist");
        } else {
          const newUser = await new userModel({
            name: username,
            email: email,
            password: password,
            isActive: false,
          });
          await newUser.save();
          sendMail(email)
          console.log("User Created Successfully");
        }
      } catch (error) {
        console.log("Error in new user ", error);
      }
}
const userLogin = async(email, password)=>{
    try {
        const user = await userModel.findOne({ email: email });
        if(user){
          if (user.isActive && user.password == password) {
            console.log("Login Success");
          }else if (user.password != password) {
            console.log("Password is incorrect");
          } else if (!user.isActive) {
            console.log("Please Verify your account");
          } 
        }else{
          console.log("User does not exist")
        }
      } catch (error) {
        console.log("Error in new user ", error);
      }
}

const userVerification = ()=>{}

module.exports = {
    userRegistration,
    userLogin,
    userVerification
}
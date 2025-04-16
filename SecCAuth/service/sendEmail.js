const nodemailer = require("nodemailer")


const sendMail = (email, userName)=>{
    const transport = nodemailer.createTransport({
        service:"gmail",
        auth:{
            user:"test.duck.mail@gmail.com",
            pass:"hkhmvpgukunqzmxk"
        }
    })
    const verificationLink = "http://localhost:5500/verifyemail?id=a29zb2cxNzUxNUBhbmxvY2MuY29t";
    const mail = ({
        from:"test.duck.mail@gmail.com",
        to:email,
        subject:"Email Verification",
        // text:"Your account has been created successfully"
        html:`Dear ${userName},<br>Your account has been created Successfully.<br>Please click on the link below to verify your account.<br> <a href=${verificationLink}>http://localhost:5500/verifyemail?id=a29zb2cxNzUxNUBhbmxvY2MuY29t</a><br>Regards,<br>Team Sec-C`

    })
    
    transport.sendMail(mail, (err)=>{
        if(err){
            console.log("Email send failure ", err)
        }
        else{
            console.log("Email sent success")
        }
    })
}

module.exports = sendMail;
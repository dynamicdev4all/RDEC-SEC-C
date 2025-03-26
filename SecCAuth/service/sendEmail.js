const nodemailer = require("nodemailer")


const sendMail = (email)=>{
    const transport = nodemailer.createTransport({
        service:"gmail",
        auth:{
            user:"test.duck.mail@gmail.com",
            pass:"hkhmvpgukunqzmxk"
        }
    })
    
    const mail = ({
        from:"test.duck.mail@gmail.com",
        to:email,
        subject:"Email Verification",
        text:"Your account has been created successfully"
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
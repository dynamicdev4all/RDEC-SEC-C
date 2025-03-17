const e = require("express");

const app = e();

const path = require("path");

const mongoose = require("mongoose");

mongoose
  .connect(
    "mongodb+srv://piebytwo014:piebytwo014@cluster0.by4i3.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  )
  .then(() => {
    console.log("Connection Success");
  })
  .catch(() => {
    console.log("Some Error Occured");
  });

app.use(e.urlencoded({ extended: true }));

//here we are defining routes

app.get("/", (req, res) => {
  // res.sendFile("C:\Users\ACER\Documents\SecCAuth\public\index.htmls")

  res.sendFile(path.join(__dirname, "public", "index.html"));
  //   console.log("This is the root route");
}); //main route
app.get("/login", (req, res) => {
  //   console.log("This is the login route");
  res.sendFile(path.join(__dirname, "public", "login.html"));
});
app.get("/register", (req, res) => {
  //   console.log("This is the register route");
  res.sendFile(path.join(__dirname, "public", "register.html"));
});
app.post("/create_new_user", (req, res) => {
  //   console.log("This is the register route");
  console.log("I have called new user");
  console.log(req.body);
});

app.listen(5500, () => {
  console.log("server started");
});

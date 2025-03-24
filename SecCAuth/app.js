const e = require("express");

const app = e();

const path = require("path");

const mongoose = require("mongoose");

mongoose
  .connect(
    "mongodb+srv://piebytwo014:piebytwo014@cluster0.cz5ri.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  )
  .then(() => {
    console.log("Connection Success");
  })
  .catch(() => {
    console.log("Some Error Occured");
  });

app.use(e.urlencoded({ extended: true }));

const userSchema = mongoose.Schema({
  name: String,
  email: String,
  password: String,
  isActive: Boolean,
});

const userModel = mongoose.model("user", userSchema);

//here we are defining routes

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
}); //main route
app.get("/login", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "login.html"));
});
app.get("/register", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "register.html"));
});
app.post("/create-new-user", async (req, res) => {
  try {
    const { username, email, password } = req.body;

    const newUser = await new userModel({
      name: username,
      email: email,
      password: password,
      isActive: false,
    });

    await newUser.save();

    console.log("User Created Successfully");
  } catch (error) {
    console.log("Error in new user ", error);
  }
});
app.post("/login-user", async (req, res) => {
  try {
    const { email, password } = req.body;

    const user = await userModel.findOne({ email: email });

    if (user.isActive && user.password == password) {
      console.log("Login Success");
    } else if (!user.isActive) {
      console.log("Please Verify your account");
    } else if (user.password != password) {
      console.log("Password is incorrect");
    }
  } catch (error) {
    console.log("Error in new user ", error);
  }
});

app.listen(5500, () => {
  console.log("server started");
});

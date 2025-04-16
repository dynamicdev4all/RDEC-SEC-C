const e = require("express");
const app = e();
const path = require("path");
const dbconn = require("./config/databaseConn");
const { userRegistration, userLogin } = require("./controllers/userController");
app.use(e.urlencoded({ extended: true }));

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
  const { username, email, password } = req.body;
  userRegistration(username, email, password)
});
app.post("/login-user", async (req, res) => {
  const { email, password } = req.body;
  userLogin(email,password)
});

app.get("/verifyemail", (req, res) => {
 console.log("Demo")
 console.log(req.query.id)
});

app.listen(5500, () => {
  console.log("server started");
});

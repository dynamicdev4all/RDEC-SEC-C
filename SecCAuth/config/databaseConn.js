const mongoose = require("mongoose");

const dbconn = mongoose
  .connect(
    "mongodb+srv://piebytwo014:piebytwo014@cluster0.cz5ri.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  )
  .then(() => {
    console.log("Connection Success");
  })
  .catch((err) => {
    console.log("Some Error Occured", err);
  });

module.exports = dbconn;
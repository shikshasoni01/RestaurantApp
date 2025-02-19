import React, { useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";

import Image from "./../../components/images/foodie.jpeg";
import { useNavigate } from "react-router-dom";
import "../../../src/./App.css";
export const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  let Submit = async (e) => {
    e.preventDefault();
    const newEntry = {
      email: email,
      password: password,
    };
    console.log(newEntry);
    if (email === "" || password === "")
      return window.alert("Please Fill out the field first");
    else {
      const url = "http://localhost:5000/api/user/login";
      const params = {
        method: "post",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newEntry),
      };
      // await axios
      //   .post("http://localhost:5000/api/user/login", newEntry)
      //   .then((res) => {
      //     return res.json();
      //   })
      //   .then((data) => {
      //     console.log(data);
      //     if (data.message !== "Login successful") return;
      //     navigate("/Home");
      //   });
      try {
        const res = await axios.post(
          "http://localhost:5000/api/user/login",
          newEntry
        );
        console.log("Response from backend:", res.data);
        console.log(res.data);
        //updateFormData(res.data); // Store the response in state
        navigate("/Home");
      } catch (error) {
        alert("Passowrd is wrong");
        console.error("Error saving record:", error);
      }
    }
  };

  return (
    <>
      <Navbar />
      <div className="App">
        <div className="auth-form-container">
          <h2>Login</h2>
          <form className="login-form" onSubmit={Submit}>
            <label htmlFor="email">email</label>
            <input
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              type="email"
              placeholder="Enter your email id"
            />
            <label htmlFor="password">password</label>
            <input
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              type="password"
              placeholder="********"
            />
            <button>Log In</button>
          </form>
        </div>
      </div>
      <img className="login" src={Image} />
    </>
  );
};

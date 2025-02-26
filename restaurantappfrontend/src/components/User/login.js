import React, { useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import { useNavigate } from "react-router-dom";
// import "../../../src/./App.css";
import "../User/login.css";
import Image from "./../../components/images/foodie.jpeg";

export const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const isValidEmail = (email) => {
    // Basic regex for email validation
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  };

  const submitHandler = async (e) => {
    e.preventDefault();
    if (email === "" || password === "") {
      return window.alert("Please fill out the fields first.");
    }

    if (!isValidEmail(email)) {
      return window.alert("Please enter a valid email address.");
    }

    const newEntry = {
      email: email,
      password: password,
    };

    const url = "http://localhost:5000/api/user/login";

    try {
      const res = await axios.post(url, newEntry);
      console.log("Response from backend:", res.data);
      navigate("/Home");
    } catch (error) {
      // Handle error more specifically based on the error response
      if (error.response && error.response.data) {
        alert(error.response.data.message || "Login failed. Please try again.");
      } else {
        alert("Something went wrong. Please try again later.");
      }
      console.error("Error saving record:", error);
    }
  };

  return (
    <>
      <Navbar></Navbar>
      <div className="container-content">
        <div className="login-container">
          <div className="auth-form-container">
            <h2>Login</h2>
            <form className="login-form" onSubmit={submitHandler}>
              <label htmlFor="email">Email</label>
              <input
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                type="email"
                placeholder="Enter your email id"
              />
              <label htmlFor="password">Password</label>
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
      </div>
    </>
  );
};

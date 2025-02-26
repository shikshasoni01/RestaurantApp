import React, { useState } from "react";
import Navbar from "../Navbar/Navbar";
import axios from "axios";
import Image from "./../../components/images/foodie.jpeg";
import { useNavigate } from "react-router-dom";
import "../User/register.css";
export const Register = () => {
  const [fullName, setfullName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("");
  const [formData, updateFormData] = React.useState([]);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    // setRole(() => {
    //   "USER";
    // });
    if (email === "admin@mailinator.com") setRole("ADMIN");
    else
      setRole(() => {
        "USER";
      });
    console.log(role);
    console.log(email);
    const newEntry = {
      fullName: fullName,
      email: email,
      password: password,
      role: role,
    };
    console.log(newEntry);
    try {
      if (fullName === "" || email === "" || password === "")
        return window.alert("Please fill out the field first");

      const res = await axios.post(
        "http://localhost:5000/api/user/register",
        newEntry
      );
      console.log("Response from backend:", res.data);
      console.log(res.data);
      updateFormData(res.data); // Store the response in state
      navigate("/login");
    } catch (error) {
      console.error("Error saving record:", error);
    }
  };

  return (
    <div>
      <Navbar />
      <div className="container-content">
        <div className="register-container">
          <div className="auth-form-container">
            <h2>Register</h2>
            <form className="register-form" onSubmit={handleSubmit}>
              <label htmlFor="fullname">Full name</label>
              <input
                value={fullName}
                onChange={(e) => {
                  setfullName(e.target.value);
                }}
                type="fullname"
                placeholder="Enter your Full name"
              />
              <label htmlFor="email">Email</label>
              <input
                value={email}
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
                type="email"
                placeholder="Enter your email"
              />
              <label htmlFor="password">Password</label>
              <input
                value={password}
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                type="password"
                placeholder="Enter your password"
              />
              <button>Register</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

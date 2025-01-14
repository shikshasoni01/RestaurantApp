import React, { useState } from "react";
import { Link } from "react-router-dom";
import Images from "./../images/logo.jpg";

const Navbar2 = (props) => {
  return (
    <nav
      className="navbar navbar-expand-lg bg-light"
      style={{ fontFamily: ' "Merriweather", serif' }}
    >
      <a className="nav-link" style={{ marginLeft: "20px" }}>
        <img
          src={Images}
          alt="Leaf is busy"
          style={{ width: "25px", height: "25px" }}
        />
        LEAF RESTAURANT <span className="sr-only"></span>
      </a>
      <Link className="navbar-brand mx-auto">
        <b></b>
      </Link>
      <Link className="btn btn-primary mx-4" to="/menu" role="button">
        Menu
      </Link>
      <Link className="btn btn-primary mx-4" to="/aboutus" role="button">
        About Us
      </Link>
      <Link className="btn btn-primary mx-1" to="/contactus" role="button">
        Contact Us
      </Link>
      <Link className="btn btn-primary mx-4" to="/cart">
        Cart
        {props.Count}
      </Link>
      <Link className="btn btn-primary mx-1" to="/login" role="button">
        Sign Out
      </Link>
    </nav>
  );
};

export default Navbar2;

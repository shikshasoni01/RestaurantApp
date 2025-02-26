import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg bg-muted p-0">
      <div
        className="container-fluid p-2"
        style={{ background: "linear-gradient(#f6d365, #fda085)" }}
      >
        <a class="nav-link">
          LEAF RESTAURANT <span class="sr-only"></span>
        </a>
        <div
          className="collapse navbar-collapse"
          id="navbarSupportedContent"
          style={{ background: "linear-gradient(#f6d365, #fda085)" }}
        >
          <ul className="navbar-nav me-auto mb-2 mb-lg-0"></ul>
          <Link
            className="btn btn-primary mx-2"
            to="/login"
            role="button"
            // style={{ background: "linear-gradient(#f6d365, #fda085)" }}
          >
            Login
          </Link>
          <Link className="btn btn-primary mx-2" to="/register" role="button">
            SignUp
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

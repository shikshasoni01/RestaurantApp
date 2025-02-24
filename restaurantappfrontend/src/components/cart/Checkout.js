import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Button from "react-bootstrap/Button";
import InputGroup from "react-bootstrap/InputGroup";
import Form from "react-bootstrap/Form";
import "./Checkout.css";
import image from "./../images/food.webp";
import axios from "axios";

export default function Checkout() {
  const [data, setData] = useState([]);

  const [userLogged, setUserLogged] = useState({
    userId: 1,
    name: "shiksha soni",
    email: "soni@mailinator.com",
    roleId: 1,
    roleType: "ADMIN",
  });

  const fetchUser = async () => {
    const url = "http://localhost:5000/api/user/userLogged";
    try {
      const response = await axios.get(url, {
        headers: {
          "Content-Type": "application/json",
        },
      });
      console.log(response.data.data);
      setUserLogged(response.data.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  const getData = async (id) => {
    const url = "http://localhost:5000/api/cart/getCartItemByUser";

    try {
      const response = await axios.get(url, {
        headers: {
          userId: id,
        },
      });
      console.log(response.data.data);
      setData(response.data.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  useEffect(async () => {
    await fetchUser();
    await getData(userLogged.userId);
  }, []);

  return (
    <>
      <div
        style={{
          height: "100%",
          backgroundImage: `url(${image})`,
          backgroundSize: "cover",
          fontFamily: ' "Merriweather", serif',
        }}
      >
        <div className="checkout-container">
          <h1 className="h1">
            <div> Your Food Cart</div>
          </h1>
          <Link className="btn btn-light mx-1" to="/Home" role="button">
            Back
          </Link>
          <Link
            className="btn btn-primary mx-auto"
            style={{ left: "650px", top: "200px" }}
            to="/payment"
          >
            Payment
          </Link>
          <h3 className="h3">
            <i>Checkout your favourite food Added: </i>
          </h3>
          <div className="cart-container">
            {console.log(data)}
            {data.map((f) => (
              <div className="fooditem">
                <div className="foodname">{f.foodName}</div>
                <div>{f.foodPrice}</div>
                <div>{f.quantity}</div>
                <div>{f.foodPrice * f.quantity}</div>
              </div>
            ))}

            <div className="coupon">
              <InputGroup className="mb-3">
                <Form.Control
                  placeholder="Have a coupon code"
                  aria-label=""
                  aria-describedby="basic-addon2"
                />
                <Button variant="outline-primary" id="button-addon2">
                  Apply
                </Button>
              </InputGroup>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

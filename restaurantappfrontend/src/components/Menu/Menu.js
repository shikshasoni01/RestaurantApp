import React, { useEffect, useState } from "react";
import Card from "react-bootstrap/Card";
import Navbar2 from "../Navbar/Navbar2";
import Button from "react-bootstrap/Button";
import "./Menu.css";
import axios from "axios";
import Badge from "react-bootstrap/Badge";

const Menu = () => {
  const [category, setCategory] = useState([]);
  const [menu, setMenu] = useState([]);
  const [isCartButtonClicked, setIsCartButtonClicked] = useState(false);
  const [userLogged, setUserLogged] = useState({});

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
      console.log(userLogged);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  async function addToCart(Id, fid) {
    const url = "http://localhost:5000/api/cart/addCart";

    const payload = {
      foodId: fid,
      userId: Id,
      quantity: 1,
      // Replace with a function to get the actual user ID
    };

    try {
      const response = await axios.post(url, payload, {
        headers: {
          "Content-Type": "application/json",
        },
      });

      console.log("Added to cart:", response.data);
    } catch (error) {
      console.error(
        "Failed to add to cart:",
        error.response?.data || error.message
      );
    }
  }

  const fetchData = async () => {
    const url = "http://localhost:5000/api/category/getAllCategory";
    try {
      const response = await axios.get(url, {
        headers: {
          "Content-Type": "application/json",
        },
      });
      console.log(response.data.data);
      setCategory(response.data.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  const fetchMenu = async (id) => {
    console.log(id);
    const url = "http://localhost:5000/api/food/getAllFoodByCategory";
    try {
      const response = await axios.get(url, {
        headers: {
          // "Content-Type": "application/json",
          id: id,
        },
      });
      console.log(response.data.data);
      setMenu(response.data.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  useEffect(() => {
    fetchData();
    fetchUser();
  }, []);

  return (
    <div>
      <Navbar2 />
      {console.log(userLogged)}
      <div className="menu">
        <div className="category">
          {Array.isArray(category)
            ? category.map((f) => {
                return (
                  <Card className="card">
                    {/* <Card.Img variant="top" src={f.food_image} />
                  <Badge bg="secondary">Huge Discounts</Badge> */}
                    <Card.Body>
                      <Card.Title>{f.categoryName}</Card.Title>
                      <Button
                        variant="primary"
                        onClick={() => {
                          fetchMenu(f.id);
                        }}
                      >
                        See Dishes
                      </Button>
                    </Card.Body>
                  </Card>
                );
              })
            : "No record found"}
        </div>
        <br></br>
        <br></br>
        <div className="items">
          {Array.isArray(menu)
            ? menu.map((f) => {
                return (
                  <Card className="card">
                    <Card.Img variant="top" src={f.food_image} />
                    <Badge bg="secondary">Huge Discounts</Badge>
                    <Card.Body>
                      <Card.Title>{f.name}</Card.Title>
                      <Card.Text>Price {f.price}/-</Card.Text>
                      <Button
                        variant="primary"
                        onClick={() => {
                          setIsCartButtonClicked(true);
                          addToCart(userLogged.userId, f.id);
                        }}
                      >
                        {isCartButtonClicked ? "Added to cart" : "Add to cart"}
                      </Button>
                    </Card.Body>
                    <Card.Text>
                      <div className="ratings">
                        {f.rating}
                        <i class="fa fa-star rating-color"></i>
                      </div>
                    </Card.Text>
                  </Card>
                );
              })
            : "No record found"}
        </div>
      </div>
    </div>
  );
};
export default Menu;

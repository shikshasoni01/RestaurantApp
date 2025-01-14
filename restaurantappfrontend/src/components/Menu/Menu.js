import React, { useEffect, useState } from "react";
import Card from "react-bootstrap/Card";
import Navbar2 from "../Navbar/Navbar2";
import Button from "react-bootstrap/Button";
import "./Menu.css";
import axios from "axios";
import Badge from "react-bootstrap/Badge";

const Menu = () => {
  const [records, setData] = useState([]);
  // const [count,setCount]=useState(0)
  // {
  //   setCount(count+1)
  // }

  function addToCart(id) {
    const url = "http://localhost:5000/api/cart";
    const params = {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        food_id: id,
        user_id: 2,
      }),
    };
    fetch(url, params)
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        console.log(data);
      });
    // setCount(count+1)
  }
  // const fetchData = () => {
  //   const url = "http://localhost:5000/api/foods";
  //   const params = {
  //     method: "get",
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //   };
  //   fetch(url, params)
  //     .then((res) => {
  //       return res.json();
  //     })
  //     .then((data) => {
  //       console.log(data);
  //       setData(data);
  //     });
  // };
  const fetchData = async () => {
    const url = "http://localhost:5000/api/food/getAllFoodByCategory";
    try {
      const response = await axios.get(url, {
        headers: {
          "Content-Type": "application/json",
          id: 2,
        },
      });
      console.log(response.data.data);
      setData(response.data.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <Navbar2 />

      <div className="menu">
        {console.log(records)}
        {console.log(Array.isArray(records))}
        {Array.isArray(records)
          ? records.map((f) => {
              return (
                <Card className="card">
                  {/* <Card.Img variant="top" src={f.food_image} /> */}
                  <Badge bg="secondary">Huge Discounts</Badge>
                  <Card.Body>
                    <Card.Title>{f.name}</Card.Title>
                    <Card.Text>Price {f.price}/-</Card.Text>
                    <Button
                      variant="primary"
                      onClick={() => {
                        addToCart(f.food_id);
                      }}
                    >
                      Add to cart
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
  );
};
export default Menu;

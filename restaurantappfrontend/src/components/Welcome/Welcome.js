import Navbar2 from "../Navbar/Navbar2";
import "./Welcome.css";
function Welcome() {
  return (
    <>
      <Navbar2 />
      <div class="welcome">
        <h2>Welcome To Home Page</h2>

        <div class="hero">
          <div class="coupon">Get 20% Off! Use Code: FOOD20</div>
          <div class="content">
            <h1>Welcome to Leaf Delight</h1>
            <p>Experience the finest dining with our exquisite menu.</p>
            <button onclick="bookTable()">Book a Table</button>
          </div>
        </div>
      </div>
    </>
  );
}
export default Welcome;

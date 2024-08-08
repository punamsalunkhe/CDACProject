1).login.js


import React from "react";
import "./login.css";
import { Link } from "react-router-dom";

const Login = () => {
  return (
    <div className="addUser">
      <h3>Sign in</h3>
      <form className="addUserForm">
        <div className="inputGroup">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            autoComplete="off"
            placeholder="Enter your Email"
          />
          <label htmlFor="Password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            autoComplete="off"
            placeholder="Enter your Password"
          />
          <button type="submit" class="btn btn-primary">
            Login
          </button>
        </div>
      </form>
      <div className="login">
        <p>Don't have Account? </p>
        <Link to="/" type="submit" class="btn btn-success">
          Sign Up
        </Link>
      </div>
    </div>
  );
};

export default Login;


2)login.css
.addUser {
    background-color: white;
    width: 25%;
    margin: 50px auto;
    /* margin in top and bottom will be 50px  */
    /* left and right auto  */
    padding: 40px;
    border-radius: 10px;
    box-shadow: 1px 1px 8px rgba(0, 0, 0, 0.065);
  
    /* horizon offset vertical offset blur offset  */
    /* opacity of shadow */
    /* red, green, blue, and (opacity ). */
  }
  .addUserForm .inputGroup {
    width: 100%;
    display: flex;
    flex-direction: column;
  }
  
  .addUserForm .inputGroup label {
    margin-top: 10px;
  }
  
  .addUserForm .inputGroup input {
    margin-top: 5px;
    padding: 10px;
  }
  
  .inputGroup button {
    margin-top: 10px;
  }
  .login {
    margin-top: 30px;
    text-align: center;
  }
  
  .login .btn.btn-success {
    width: 50%;
  }
  
  .addUser h3 {
    text-align: center;
    font-weight: bold;
    color: darkcyan;
    text-transform: uppercase;
    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7);
  }

3).signup.css
.addUser {
    background-color: white;
    width: 25%;
    margin: 50px auto;
    /* margin in top and bottom will be 50px  */
    /* left and right auto  */
    padding: 40px;
    border-radius: 10px;
    box-shadow: 1px 1px 8px rgba(0, 0, 0, 0.065);
  
    /* horizon offset vertical offset blur offset  */
    /* opacity of shadow */
    /* red, green, blue, and (opacity ). */
  }
  .addUserForm .inputGroup {
    width: 100%;
    display: flex;
    flex-direction: column;
  }
  
  .addUserForm .inputGroup label {
    margin-top: 10px;
  }
  
  .addUserForm .inputGroup input {
    margin-top: 5px;
    padding: 10px;
  }
  
  .inputGroup button {
    margin-top: 10px;
  }
  .login {
    margin-top: 30px;
    text-align: center;
  }
  
  .login .btn.btn-primary {
    width: 50%;
  }
  
  .addUser h3 {
    text-align: center;
    font-weight: bold;
    color: darkcyan;
    text-transform: uppercase;
    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7);
  }
4)signup.js
import React from "react";
import "./signup.css";
import { Link } from "react-router-dom";

const Signup = () => {
  return (
    <div className="addUser">
      <h3>Sign Up</h3>
      <form className="addUserForm">
        <div className="inputGroup">
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            autoComplete="off"
            placeholder="Enter your name"
          />
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            autoComplete="off"
            placeholder="Enter your Email"
          />
          <label htmlFor="Password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            autoComplete="off"
            placeholder="Enter Password"
          />
          <button type="submit" class="btn btn-success">
            Sign Up
          </button>
        </div>
      </form>
      <div className="login">
        <p>Already have an Account? </p>
        <Link to="/login" type="submit" class="btn btn-primary">
          Login
        </Link>
      </div>
    </div>
  );
};

export default Signup;
5)App.js
import Signup from "./signup/Signup";
import Login from "./login/Login";
import "./App.css";
import { RouterProvider, createBrowserRouter } from "react-router-dom";

function App() {
  const route = createBrowserRouter([
    {
      path: "/",
      element: <Signup />,
    },
    {
      path: "/login",
      element: <Login />,
    },
  ]);
  return (
    <div className="App">
      <RouterProvider router={route}></RouterProvider>
    </div>
  );
}

export default App;

7)App.css
.App {
  text-align: center;
}

.App-logo {
  height: 40vmin;
  pointer-events: none;
}

@media (prefers-reduced-motion: no-preference) {
  .App-logo {
    animation: App-logo-spin infinite 20s linear;
  }
}

.App-header {
  background-color: #282c34;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: calc(10px + 2vmin);
  color: white;
}

.App-link {
  color: #61dafb;
}

@keyframes App-logo-spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
component is blank but created

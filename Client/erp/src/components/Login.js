import axios from "axios";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { CONFIG } from "../ultils/constants";

function Login() {
  const [user1, setUser1] = useState({});
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  // useEffect(() => {
  //   let user = localStorage.getItem("account");
  //   if (user) setUser1(JSON.parse(user));
  // }, []);

  const storeUser = (user) => {
    localStorage.setItem("account", JSON.stringify(user));
  };
  // let history = useHistory();

  const onclickLoginAccount = (event) => {
    event.preventDefault();
    axios
      .get(
        `${CONFIG.SERVER}/account/get-account-by-name-pass/${username}/${password}`
      )
      .then(function (response) {
        if (!response.data) {
          setMessage("Error password or user");
        } else {
          console.log(response.data);
          setUser1(response.data);
          setUsername("");
          setPassword("");
          setMessage("Login success " + response.data.fullname);
          console.log("user1 ", user1);
          storeUser(response.data);
          navigate("/home");
        }
      })
      .catch(function (error) {});
  };

  return (
    <div>
      <header>
        <div className="App login">
          <h1>Login account</h1>
          <form onSubmit={onclickLoginAccount}>
            <div className=" flex ">
              <div className="in-block"></div>
              <div className="in-block">
                <label className="labelInputEmployee">Username: </label> <br />
                <InputText
                  type="text"
                  id="username"
                  required
                  value={username || ""}
                  aria-describedby="username-help"
                  onChange={(e) => setUsername(e.target.value)}
                />
                <br />
                <small id="username-help"></small>
              </div>
              <br />
              <div className="in-block">
                <label className="labelInputEmployee">Password: </label> <br />
                <InputText
                  id="password"
                  required
                  value={password ? password : ""}
                  aria-describedby="password-help"
                  onChange={(e) => setPassword(e.target.value)}
                />
                <br />
                <small id="password-help">{message}</small>
              </div>
              <div className="in-block"></div>
            </div>
            <Button label="Submit" type="submit" />
          </form>
        </div>
      </header>
    </div>
  );
}

export default Login;

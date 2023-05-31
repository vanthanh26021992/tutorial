import axios from "axios";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import { CONFIG } from "../../ultils/constants";
import SignUpEmployee from "./SignUpEmployee";

function LoginEmployee() {
  const [user1, setUser1] = useState({});
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [messagePass, setMessagePass] = useState("");
  const [messageUsername, setMessageUsername] = useState("");

  const onclickLogin = () => {
    axios
      .get(
        `${CONFIG.SERVER}/getEmployeeByUsernameAndPass/${username}/${password}`
      )
      .then(function (response) {
        console.log("rp username ", response.data.username);
        console.log("username ", username);
        if (response.data.username !== username || username === "") {
          setMessageUsername("Error username");
        } else if (response.data.password !== password || password === "") {
          setMessagePass("Error password");
        } else {
          setUser1(response.data);
          setUsername("");
          setPassword("");
          setMessagePass("Login success " + response.data.fullname);
        }
      })
      .catch(function (error) {});
  };

  return (
    <div className="">
      <header>
        <div className="card  login">
          <h1>Login employee</h1>
          <form>
            <div className=" flex ">
              <div className="in-block"></div>

              <div className="in-block">
                <label className="labelInputEmployee">Username: </label> <br />
                <InputText
                  type="text"
                  name="username"
                  minLength={7}
                  aria-invalid="false"
                  value={username ? username : ""}
                  aria-describedby="username-help"
                  onChange={(e) => setUsername(e.target.value)}
                  required
                />
                <br />
                <small id="username-help">{messageUsername}</small>
              </div>
              <br />
              <div className="in-block">
                <label className="labelInputEmployee">Password: </label> <br />
                <InputText
                  required
                  minLength={7}
                  value={password ? password : ""}
                  aria-describedby="password-help"
                  onChange={(e) => setPassword(e.target.value)}
                />
                <br />
                <small id="password-help">{messagePass}</small>
              </div>
              <div className="in-block"></div>
            </div>
            <SignUpEmployee />
            <Button label="Submit" onClick={() => onclickLogin()} />
          </form>
        </div>
      </header>
    </div>
  );
}

export default LoginEmployee;

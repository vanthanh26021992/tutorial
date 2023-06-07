import axios from "axios";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import SignUp from "../components/SignUp";
import { CONFIG } from "../ultils/constants";

function Login(props) {
  const [user1, setUser1] = useState({});
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const [isShowLoginForm, setShowLoginForm] = useState(false);
  const { getAccounts } = props;

  const onclickLoginAccount = (event) => {
    event.preventDefault();
    console.log(username);
    console.log(password);
    axios
      .get(`${CONFIG.SERVER}/get-account-by-name-pass/${username}/${password}`)
      .then(function (response) {
        if (!response.data) {
          setMessage("Error password or user");
          setShowLoginForm(false);
        } else {
          setUser1(response.data);
          setUsername("");
          setPassword("");
          setMessage("Login success " + response.data.fullname);
          setShowLoginForm(true);
        }
      })
      .catch(function (error) {
        setShowLoginForm(false);
      });
  };

  return (
    <div>
      <header className={isShowLoginForm ? "hidden" : undefined}>
        <div className="card  login">
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
          <SignUp getAccounts={getAccounts} />
        </div>
      </header>
      <div className={isShowLoginForm ? undefined : "hidden"}>
        Wellcome {user1.username} to ERP
      </div>
    </div>
  );
}

export default Login;
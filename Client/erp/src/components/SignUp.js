import axios from "axios";
import moment from "moment";
import { Button } from "primereact/button";
import { Dialog } from "primereact/dialog";
import { Dropdown } from "primereact/dropdown";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import { CONFIG } from "../ultils/constants";
import { validPassword, validUsername } from "./Regex";

function SignUp(props) {
  const [visibleSignUp, setVisibleSignUp] = useState(false);
  const [username, setUsername] = useState(false);
  const [password, setPassword] = useState(false);
  const [rePassword, setRePassword] = useState(false);
  const [fullname, setFullname] = useState(false);
  const [age, setAge] = useState(false);
  const [phone, setPhone] = useState(false);
  const [address, setAddress] = useState(false);
  const [gender, setGender] = useState(false);
  const [messagePass, setMessagePass] = useState(false);
  const [messagePassInvalid, setMessagePassInvalid] = useState(false);
  const [messageUsername, setMessageUsername] = useState(false);
  const genderList = [{ name: "Male" }, { name: "Female" }];
  const date = moment().format("YYYYMMDD");

  const onClickSignUp = (todo) => {
    console.log("username: " + username);
    console.log("password: " + password);
    console.log("rePassword: " + rePassword);
    console.log("fullname: " + fullname);
    console.log("age: " + age);
    console.log("phone: " + phone);
    console.log("address: " + address);
    console.log("gender: " + gender.name);
    console.log("create_date: " + date);

    if (password !== rePassword) {
      setMessagePass("Pass and re-pass do not match!");
      setVisibleSignUp(true);
    } else {
      setMessagePass("");
      setVisibleSignUp(true);
    }

    if (!validUsername.test(username)) {
      setMessageUsername("Invalid");
      setVisibleSignUp(true);
    } else {
      setMessageUsername("");
      setVisibleSignUp(true);
    }

    if (!validPassword.test(password)) {
      setMessagePassInvalid("Invalid");
      setVisibleSignUp(true);
    } else {
      setMessagePassInvalid("");
      setVisibleSignUp(true);
    }

    if (
      (password === rePassword) &
      validUsername.test(username) &
      validPassword.test(password)
    ) {
      const headers = { "Content-Type": "application/json;charset=utf-8" };
      axios
        .post(
          `${CONFIG.SERVER}/account/insert`,
          JSON.stringify({
            username: username,
            password: password,
            fullname: fullname,
            age: age,
            phone: phone,
            address: address,
            gender: gender.name,
            create_date: date,
            update_date: "",
          }),
          { headers }
        )
        .then(() => {
          props.getAccounts();
        })
        .catch((error) => console.log(error));

      setVisibleSignUp(false);
    }
  };

  return (
    <div className="App">
      <header>
        <Button label="Sign up" text onClick={() => setVisibleSignUp(true)} />
        <div className=" flex ">
          <Dialog
            header="Create Account"
            style={{ width: "50vw", textAlign: "center" }}
            visible={visibleSignUp}
            onHide={() => setVisibleSignUp(false)}
          >
            <div className="">
              <div className="">
                <div className="flex flex-column gap-2">
                  <div className="in-block">
                    <label className="labelInputEmployee">Username: </label>{" "}
                    <br />
                    <InputText
                      required
                      minLength={7}
                      aria-describedby="username-help"
                      onChange={(e) => setUsername(e.target.value)}
                    />
                    <small id="username-help">{messageUsername || ""}</small>
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">Password: </label>{" "}
                    <br />
                    <InputText
                      type="password"
                      required
                      minLength={7}
                      aria-describedby="password-help"
                      onChange={(e) => setPassword(e.target.value)}
                    />
                    <small id="password-help">{messagePassInvalid}</small>
                  </div>

                  <div className="in-block">
                    <label className="labelInputEmployee">Re Password: </label>{" "}
                    <br />
                    <InputText
                      id="rePassword"
                      type="password"
                      required
                      minLength={7}
                      aria-describedby="rePassword-help"
                      onChange={(e) => setRePassword(e.target.value)}
                    />
                    <small id="password-help">{messagePass}</small>
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">Fullname: </label>{" "}
                    <br />
                    <InputText
                      id="fullname"
                      aria-describedby="fullname-help"
                      onChange={(e) => setFullname(e.target.value)}
                    />
                    <small id="fullname-help"></small>
                  </div>
                </div>

                <div className="flex flex-column gap-2">
                  <div className="in-block">
                    <label className="labelInputEmployee">Age: </label> <br />
                    <InputText
                      id="age"
                      aria-describedby="age-help"
                      onChange={(e) => setAge(e.target.value)}
                    />
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">Phone: </label> <br />
                    <InputText
                      id="phone"
                      aria-describedby="phone-help"
                      onChange={(e) => setPhone(e.target.value)}
                    />
                    <small id="phone-help"></small>
                  </div>

                  <div className="in-block">
                    <label className="labelInputEmployee">Address: </label>{" "}
                    <br />
                    <InputText
                      id="address"
                      aria-describedby="address-help"
                      onChange={(e) => setAddress(e.target.value)}
                    />
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">Gender: </label>{" "}
                    <br />
                    <Dropdown
                      value={gender}
                      onChange={(e) => setGender(e.value)}
                      options={genderList}
                      optionLabel="name"
                      placeholder="Select a Gender"
                      className="w-full md:w-14rem"
                    />
                  </div>
                </div>
              </div>

              <div className="center">
                <Button
                  label="No"
                  icon="pi pi-times"
                  onClick={() => setVisibleSignUp(false)}
                  className="p-button-text"
                />
                <Button
                  label="Yes"
                  icon="pi pi-check"
                  onClick={(todo) => onClickSignUp(todo)}
                  autoFocus
                />
              </div>
            </div>
          </Dialog>
        </div>
      </header>
    </div>
  );
}

export default SignUp;

import axios from "axios";
import { Button } from "primereact/button";
import { Dialog } from "primereact/dialog";
import { Dropdown } from "primereact/dropdown";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import { CONFIG } from "../../ultils/constants";
import { validPassword, validUsername } from "../Regex";

function SignUpEmployee({ getEmployee, getAccounts }) {
  const [visibleSignUpEmloyee, setVisibleSignUpEmployee] = useState(false);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rePassword, setRePassword] = useState("");
  const [fullname, setFullname] = useState("");
  const [age, setAge] = useState();
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const [gender, setGender] = useState("");
  const [messagePass, setMessagePass] = useState("");
  const [messagePassInvalid, setMessagePassInvalid] = useState("");
  const [messageUsername, setMessageUsername] = useState("");
  const [startDate, setStartDate] = useState("");
  const [department, setDepartment] = useState("");
  const [endDate, setEndDate] = useState("");
  const [salary, setSalary] = useState();
  const [status, setStatus] = useState("");

  const genderList = [{ name: "Male" }, { name: "Female" }];
  const statusList = [{ name: "On" }, { name: "Off" }];

  const onClickSignUpEmployee = (todo) => {
    if (password !== rePassword) {
      setMessagePass("Pass and re-pass do not match!");
      // setVisibleSignUpEmployee(true);
    } else {
      setMessagePass("");
      // setVisibleSignUpEmployee(true);
    }

    if (!validUsername.test(username)) {
      setMessageUsername("Invalid");
      // setVisibleSignUpEmployee(true);
    } else {
      setMessageUsername("");
      // setVisibleSignUpEmployee(true);
    }

    if (!validPassword.test(password)) {
      setMessagePassInvalid("Invalid");
      // setVisibleSignUpEmployee(true);
    } else {
      setMessagePassInvalid("");
      // setVisibleSignUpEmployee(true);
    }

    // if (
    //   (password === rePassword) &
    //   validUsername.test(username) &
    //   validPassword.test(password)
    // ) {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .post(
        `${CONFIG.SERVER}/employee/insert`,
        JSON.stringify({
          username: username,
          password: password,
          fullname: fullname,
          age: age,
          phone: phone,
          address: address,
          gender: gender.name,
          startDate: startDate,
          department: department,
          endDate: endDate,
          salary: salary,
          status: status.name,
        }),
        { headers }
      )
      .then((response) => {
        getEmployee();
        getAccounts();
      })
      .catch((error) => console.log(error));
    setVisibleSignUpEmployee(false);
    //}
  };

  return (
    <div className="App">
      <header>
        <Button
          label="Sign up"
          text
          onClick={() => setVisibleSignUpEmployee(true)}
        />
        <div className=" flex justify-content-center">
          <Dialog
            header="Create Employee"
            style={{ width: "50vw", textAlign: "center" }}
            visible={visibleSignUpEmloyee}
            onHide={() => setVisibleSignUpEmployee(false)}
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
                      // id="password"
                      type="password"
                      required
                      minLength={7}
                      aria-describedby="password-help"
                      onChange={(e) => setPassword(e.target.value)}
                    />
                    <small id="password-help">
                      {messagePass ? messagePass : ""}
                    </small>
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
                    <small id="rePassword-help">
                      {messagePassInvalid || ""}
                    </small>
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

                <div className="flex flex-column gap-2">
                  <div className="in-block">
                    <label className="labelInputEmployee">StartDate: </label>{" "}
                    <br />
                    <InputText
                      id="startDate"
                      aria-describedby="startDate-help"
                      value={startDate}
                      onChange={(e) => setStartDate(e.target.value)}
                    />
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">Department: </label>{" "}
                    <br />
                    <InputText
                      id="department"
                      aria-describedby="department-help"
                      value={department}
                      onChange={(e) => setDepartment(e.target.value)}
                    />
                    <small id="department-help"></small>
                  </div>

                  <div className="in-block">
                    <label className="labelInputEmployee">EndDate: </label>{" "}
                    <br />
                    <InputText
                      id="endDate"
                      aria-describedby="endDate-help"
                      value={endDate}
                      onChange={(e) => setEndDate(e.target.value)}
                    />
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">Salary: </label>{" "}
                    <br />
                    <InputText
                      id="salary"
                      aria-describedby="salary-help"
                      onChange={(e) => setSalary(e.target.value)}
                    />
                  </div>
                </div>

                <div className="flex flex-column gap-2">
                  <div className="in-block">
                    <label className="labelInputEmployee">Status: </label>{" "}
                    <br />
                    <Dropdown
                      value={status}
                      onChange={(e) => setStatus(e.value)}
                      options={statusList}
                      optionLabel="name"
                      placeholder="Select a Status"
                      className="w-full md:w-14rem"
                    />
                  </div>
                </div>
              </div>

              <div className="center">
                <Button
                  label="No"
                  icon="pi pi-times"
                  onClick={() => setVisibleSignUpEmployee(false)}
                  className="p-button-text"
                />
                <Button
                  label="Yes"
                  icon="pi pi-check"
                  type="submit"
                  onClick={onClickSignUpEmployee}
                />
              </div>
            </div>
          </Dialog>
        </div>
      </header>
    </div>
  );
}

export default SignUpEmployee;

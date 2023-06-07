import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useEffect, useState } from "react";
import Account from "../components/Account";
import Login from "../components/Login";
import Employee from "../components/employee/Employee";
import "./App.css";
import axios from "axios";
import { CONFIG } from "../ultils/constants";

function App(props) {
  const [data, setData] = useState([]);
  const [dataEmployee, setDataEmployee] = useState([]);
  const getAccounts = () => {
    axios
      .get(`${CONFIG.SERVER}/get-all`)
      .then(function (response) {
        setData(response.data);
      })
      .catch(function (error) {});
  };
  useEffect(() => {
    getAccounts();
    // console.log("data account ", data);
  }, []);

  useEffect(() => {
    getEmployee();
    // console.log("employee ", dataEmployee);
  }, []);

  const getEmployee = () => {
    axios
      .get(`${CONFIG.SERVER}/getAllEmployee`)
      .then(function (response) {
        setDataEmployee(response.data);
        // console.log(response.data);
      })
      .catch(function (error) {});
  };

  return (
    <div className="App">
      <header>
        <Login getAccounts={getAccounts} data={data} />
        {/* <Login1 /> */}
        <Account
          getAccounts={getAccounts}
          data={data}
          getEmployee={getEmployee}
        />
        {/* <LoginEmployee /> */}
        <Employee
          getEmployee={getEmployee}
          dataEmployee={dataEmployee}
          getAccounts={getAccounts}
        />
      </header>
    </div>
  );
}

export default App;

// login account xong nhan F5 thi ko giu nguyen tk ma lai ra trang login

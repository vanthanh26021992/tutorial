import axios from "axios";
import "primeicons/primeicons.css";
import { Button } from "primereact/button";
import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import React, { useEffect, useState } from "react";
import { CONFIG } from "../../ultils/constants";
import SignUpEmployee from "./SignUpEmployee";

function Employee() {
  const [dataEmployee, setDataEmployee] = useState([]);
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [visibleDelete, setVisibleDelete] = useState(false);
  const [id, setId] = useState();
  const [accountId, setAccountId] = useState();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rePassword, setRePassword] = useState("");
  const [fullname, setFullname] = useState("");
  const [age, setAge] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const [gender, setGender] = useState("");
  const [startDate, setStartDate] = useState("");
  const [department, setDepartment] = useState("");
  const [endDate, setEndDate] = useState("");
  const [salary, setSalary] = useState();
  const [status, setStatus] = useState("");

  useEffect(() => {
    getEmployee();
  }, []);

  const getEmployee = () => {
    axios
      .get(`${CONFIG.SERVER}/employee/get-all`)
      .then(function (response) {
        setDataEmployee(response.data);
      })
      .catch(function (error) {});
  };

  const bodyEmployee = (todo) => (
    <>
      <Button
        icon="pi pi-user-edit"
        rounded
        text
        aria-label="Filter"
        onClick={() => onclickEdit(todo)}
      />
      <Button
        icon="pi pi-times"
        rounded
        text
        severity="danger"
        aria-label="Cancel"
        onClick={() => onClickShowPopupDelete(todo)}
      />
    </>
  );

  const onclickEdit = (todo) => {
    setId(todo.id);
    setAccountId(todo.accountId);
    setUsername(todo.username);
    setPassword(todo.password);
    setFullname(todo.fullname);
    setAge(todo.age);
    setAddress(todo.address);
    setPhone(todo.phone);
    setGender(todo.gender);
    setStartDate(todo.startDate);
    setDepartment(todo.department);
    setEndDate(todo.endDate);
    setSalary(todo.salary);
    setStatus(todo.status);
    setVisibleEdit(true);
  };

  const footerContentEdit = (todo) => (
    <div className="footerContentDialog">
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => onClickUpdate(todo)}
        autoFocus
      />
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleEdit(false)}
        className="p-button-text"
      />
    </div>
  );

  const onClickUpdate = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .put(
        `${CONFIG.SERVER}/employee/update`,
        JSON.stringify({
          accountId: accountId,
          username: username,
          password: password,
          fullname: fullname,
          age: age,
          address: address,
          phone: phone,
          gender: gender,
          startDate: startDate,
          department: department,
          endDate: endDate,
          salary: salary,
          status: status,
        }),
        { headers }
      )
      .then((response) => {
        getEmployee();
        setVisibleEdit(false);
      })
      .catch((error) => console.log(error));
  };

  const footerContentDelete = (todo) => (
    <div className="footerContentDialog">
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleDelete(false)}
        className="p-button-text"
      />
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => onClickDelete(todo)}
        autoFocus
      />
    </div>
  );

  const onClickShowPopupDelete = (todo) => {
    setId(todo.id);
    setVisibleDelete(true);
  };

  const onClickDelete = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .delete(`${CONFIG.SERVER}/employee/delete-by-accountId/${id}`, headers)
      .then((response) => {
        setVisibleDelete(false);
        getEmployee();
      })
      .catch((error) => console.log(error));
  };

  return (
    <div className="App">
      <SignUpEmployee getEmployee={getEmployee} />
      <div className="card">
        <DataTable value={dataEmployee} tableStyle={{ minWidth: "50rem" }}>
          <Column field="id" header="ID"></Column>
          <Column field="username" header="Username"></Column>
          <Column field="password" header="Password"></Column>
          <Column field="fullname" header="Fullname"></Column>
          <Column field="age" header="Age"></Column>
          <Column field="phone" header="Phone"></Column>
          <Column field="address" header="Address"></Column>
          <Column field="gender" header="Gender"></Column>
          <Column field="startDate" header="StartDate"></Column>
          <Column field="department" header="Department"></Column>
          <Column field="endDate" header="EndDate"></Column>
          <Column field="salary" header="Salary"></Column>
          <Column field="status" header="Status"></Column>
          <Column header="Active" body={bodyEmployee}></Column>
        </DataTable>
      </div>

      {/* Edit */}
      <div className="card flex justify-content-center">
        <Dialog
          header="Header"
          style={{ width: "50vw", textAlign: "center" }}
          visible={visibleEdit}
          onHide={() => setVisibleEdit(false)}
          footer={footerContentEdit}
        >
          <div className="">
            <div className="flex flex-column gap-2">
              <div className="in-block">
                <label className="labelInputEmployee">Username: </label> <br />
                <InputText
                  aria-describedby="username-help"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  disabled
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Password: </label> <br />
                <InputText
                  type="password"
                  aria-describedby="password-help"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
                <small id="password-help"></small>
              </div>

              <div className="in-block">
                <label className="labelInputEmployee">Re Password: </label>{" "}
                <br />
                <InputText
                  id="rePassword"
                  type="password"
                  aria-describedby="rePassword-help"
                  value={rePassword}
                  onChange={(e) => setRePassword(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Fullname: </label> <br />
                <InputText
                  id="fullname"
                  aria-describedby="fullname-help"
                  value={fullname}
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
                  value={age}
                  onChange={(e) => setAge(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Phone: </label> <br />
                <InputText
                  id="phone"
                  aria-describedby="phone-help"
                  value={phone}
                  onChange={(e) => setPhone(e.target.value)}
                />
                <small id="phone-help"></small>
              </div>

              <div className="in-block">
                <label className="labelInputEmployee">Address: </label> <br />
                <InputText
                  id="address"
                  aria-describedby="address-help"
                  value={address}
                  onChange={(e) => setAddress(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Gender: </label> <br />
                <InputText
                  id="gender"
                  aria-describedby="gender-help"
                  value={gender}
                  onChange={(e) => setGender(e.target.value)}
                />
                <small id="gender-help"></small>
              </div>
            </div>

            <div className="flex flex-column gap-2">
              <div className="in-block">
                <label className="labelInputEmployee">StartDate: </label> <br />
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
                <label className="labelInputEmployee">EndDate: </label> <br />
                <InputText
                  id="endDate"
                  aria-describedby="endDate-help"
                  value={endDate}
                  onChange={(e) => setEndDate(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Salary: </label> <br />
                <InputText
                  id="salary"
                  aria-describedby="salary-help"
                  value={salary}
                  onChange={(e) => setSalary(e.target.value)}
                />
                <small id="salary-help"></small>
              </div>
            </div>

            <div className="flex flex-column gap-2">
              <div className="in-block">
                <label className="labelInputEmployee">Status: </label> <br />
                <InputText
                  id="status"
                  aria-describedby="status-help"
                  value={status}
                  onChange={(e) => setStatus(e.target.value)}
                />
              </div>
            </div>
          </div>
        </Dialog>
      </div>

      {/* Delete */}
      <div className="card flex justify-content-center">
        <Dialog
          header="Are you sure to delete?"
          visible={visibleDelete}
          style={{ width: "50vw", textAlign: "center" }}
          onHide={() => setVisibleDelete(false)}
          footer={footerContentDelete}
        ></Dialog>
      </div>
    </div>
  );
}

export default Employee;

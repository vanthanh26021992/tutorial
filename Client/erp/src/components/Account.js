import axios from "axios";
import "primeicons/primeicons.css";
import { Button } from "primereact/button";
import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import React, { useEffect, useState } from "react";
import { CONFIG } from "../ultils/constants";
import SignUp from "./SignUp";
import AccountSevice from "../services/accountService";

function Account() {
  const [data, setData] = useState([]);
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [visibleDelete, setVisibleDelete] = useState(false);
  const [id, setId] = useState();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rePassword, setRePassword] = useState("");
  const [fullname, setFullname] = useState("");
  const [age, setAge] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const [gender, setGender] = useState("");

  const getAccounts = async () => {
    const accounts = await AccountSevice.getAccounts();
    setData(accounts);
  };

  useEffect(() => {
    getAccounts();
  }, []);

  const bodyAccount = (todo) => (
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

  const onClickShowPopupDelete = (todo) => {
    setId(todo.id);
    setVisibleDelete(true);
  };

  const onclickEdit = (todo) => {
    setId(todo.id);
    setUsername(todo.username);
    setPassword(todo.password);
    setFullname(todo.fullname);
    setAge(todo.age);
    setAddress(todo.address);
    setPhone(todo.phone);
    setGender(todo.gender);
    setVisibleEdit(true);
  };

  const footerContentEdit = (todo) => (
    <div className="footerContentDialog">
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleEdit(false)}
        className="p-button-text"
      />
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => onClickUpdate(todo)}
        autoFocus
      />
    </div>
  );

  const onClickUpdate = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .put(
        `${CONFIG.SERVER}/account/update`,
        JSON.stringify({
          id: id,
          username: username,
          password: password,
          fullname: fullname,
          age: age,
          address: address,
          phone: phone,
          gender: gender,
        }),
        { headers }
      )
      .then((response) => {
        setVisibleEdit(false);
        getAccounts();
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

  const onClickDelete = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .delete(`${CONFIG.SERVER}/account/delete/${id}`, headers)
      .then((response) => {
        setVisibleDelete(false);
        getAccounts();
      })
      .catch((error) => console.log(error));
  };

  return (
    <div className="App">
      <div className="card">
        <SignUp getAccounts={getAccounts} />
      </div>
      <div className="card">
        <DataTable value={data} tableStyle={{ minWidth: "50rem" }}>
          <Column field="id" header="ID"></Column>
          <Column field="username" header="Username"></Column>
          <Column field="password" header="Password"></Column>
          <Column field="fullname" header="Fullname"></Column>
          <Column field="age" header="Age"></Column>
          <Column field="phone" header="Phone"></Column>
          <Column field="address" header="Address"></Column>
          <Column field="gender" header="Gender"></Column>
          <Column field="create_date" header="Create_date"></Column>
          <Column field="update_date" header="Update_date"></Column>
          <Column header="Active" body={bodyAccount}></Column>
        </DataTable>
      </div>

      {/* Edit */}
      <div className="card flex justify-content-center">
        <Dialog
          header="Header"
          visible={visibleEdit}
          style={{ width: "50vw", textAlign: "center" }}
          onHide={() => setVisibleEdit(false)}
          footer={footerContentEdit}
        >
          <div className="app">
            <div className="flex flex-column gap-2">
              <div className="in-block">
                <label className="labelInputEmployee">Username: </label> <br />
                <InputText
                  aria-describedby="username-help"
                  value={username || ""}
                  onChange={(e) => setUsername(e.target.value)}
                  disabled
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Password: </label> <br />
                <InputText
                  type="password"
                  aria-describedby="password-help"
                  value={""}
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
                  value={rePassword || ""}
                  onChange={(e) => setRePassword(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Fullname: </label> <br />
                <InputText
                  id="fullname"
                  aria-describedby="fullname-help"
                  value={fullname || ""}
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
                  value={age || ""}
                  onChange={(e) => setAge(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Phone: </label> <br />
                <InputText
                  id="phone"
                  aria-describedby="phone-help"
                  value={phone || ""}
                  onChange={(e) => setPhone(e.target.value)}
                />
                <small id="phone-help"></small>
              </div>

              <div className="in-block">
                <label className="labelInputEmployee">Address: </label> <br />
                <InputText
                  id="address"
                  aria-describedby="address-help"
                  value={address || ""}
                  onChange={(e) => setAddress(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputEmployee">Gender: </label> <br />
                <InputText
                  id="gender"
                  aria-describedby="gender-help"
                  value={gender || ""}
                  onChange={(e) => setGender(e.target.value)}
                />
                <small id="gender-help"></small>
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

export default Account;

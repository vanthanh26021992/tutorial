import axios from "axios";
import "primeicons/primeicons.css";
import { Button } from "primereact/button";
import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import React, { useEffect, useState } from "react";
import { CONFIG } from "../../ultils/constants";
import SignUpSupplier from "./SignUpSupplier";

function Supplier() {
  const [dataSupplier, setDataSupplier] = useState([]);
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [visibleDelete, setVisibleDelete] = useState(false);
  const [id, setId] = useState();
  const [supplierCode, setSupplierCode] = useState("");
  const [supplierName, setSupplierName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");

  useEffect(() => {
    getSupplier();
  }, []);

  const getSupplier = () => {
    axios
      .get(`${CONFIG.SERVER}/get-all-supplier`)
      .then(function (response) {
        setDataSupplier(response.data);
      })
      .catch(function (error) {});
  };

  const bodySupplier = (todo) => (
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
    setSupplierCode(todo.supplierCode);
    setSupplierName(todo.supplierName);
    setAddress(todo.address);
    setEmail(todo.email);
    setPhone(todo.phone);
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
        `${CONFIG.SERVER}/update-supplier`,
        JSON.stringify({
          id: id,
          supplierCode: supplierCode,
          supplierName: supplierName,
          address: address,
          email: email,
          phone: phone,
        }),
        { headers }
      )
      .then((response) => {
        getSupplier();
        setVisibleEdit(false);
      })
      .catch((error) => console.log(error));
  };

  const footerContentDelete = (todo) => (
    <div className="footerContentDialog">
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => onClickDelete(todo)}
        autoFocus
      />
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleDelete(false)}
        className="p-button-text"
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
      .delete(`${CONFIG.SERVER}/delete-supplier-by-id/${id}`, headers)
      .then((response) => {
        setVisibleDelete(false);
        getSupplier();
      })
      .catch((error) => console.log(error));
  };

  return (
    <div className="App">
      <SignUpSupplier getSupplier={getSupplier} />
      <div className="card">
        <DataTable value={dataSupplier} tableStyle={{ minWidth: "50rem" }}>
          <Column field="id" header="ID"></Column>
          <Column field="supplierCode" header="SupplierCode"></Column>
          <Column field="supplierName" header="SupplierName"></Column>
          <Column field="address" header="Address"></Column>
          <Column field="email" header="Email"></Column>
          <Column field="phone" header="Phone"></Column>
          <Column header="Active" body={bodySupplier}></Column>
        </DataTable>
      </div>

      {/* Edit */}
      <div className="card flex justify-content-center">
        <Dialog
          header="Edit"
          style={{ width: "50vw", textAlign: "center" }}
          visible={visibleEdit}
          onHide={() => setVisibleEdit(false)}
          footer={footerContentEdit}
        >
          <div className="">
            <div className="flex flex-column gap-2">
              <div className="in-block">
                <label className="labelInputSupplier">SupplierCode: </label>{" "}
                <br />
                <InputText
                  aria-describedby="username-help"
                  value={supplierCode}
                  onChange={(e) => setSupplierCode(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputSupplier">SupplierName: </label>{" "}
                <br />
                <InputText
                  type="text"
                  aria-describedby="password-help"
                  value={supplierName}
                  onChange={(e) => setSupplierName(e.target.value)}
                />
                <small id="password-help"></small>
              </div>

              <div className="in-block">
                <label className="labelInputSupplier">Address: </label> <br />
                <InputText
                  type="text"
                  aria-describedby="rePassword-help"
                  value={address}
                  onChange={(e) => setAddress(e.target.value)}
                />
              </div>
              <div className="in-block">
                <label className="labelInputSupplier">Email: </label> <br />
                <InputText
                  id="email"
                  aria-describedby="email-help"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
                <small id="email-help"></small>
              </div>
            </div>

            <div className="flex flex-column gap-2">
              <div className="in-block">
                <label className="labelInputSupplier">Phone: </label> <br />
                <InputText
                  id="phone"
                  aria-describedby="phone-help"
                  value={phone}
                  onChange={(e) => setPhone(e.target.value)}
                />
                <small id="phone-help"></small>
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

export default Supplier;

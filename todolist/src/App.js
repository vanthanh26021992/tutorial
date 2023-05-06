import "./App.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Button } from "primereact/button";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import React, { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [data, setData] = useState([]);
  const [idInput, setIdInput] = useState();
  const [nameInput, setNameInput] = useState("");
  const [dateInput, setDateInput] = useState("");
  const [statusInput, setStatusInput] = useState("");
  const [visibleDelete, setVisibleDelete] = useState(false);
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [visibleInsert, setVisibleInsert] = useState(false);

  useEffect(() => {
    axios({
      method: "get",
      url: `http://localhost:8080/select`,
      responseType: "json",
    })
      .then(function (response) {
        setData(response.data);
      })
      .catch((error) => console.log(error));
  }, [data]);

  // useEffect(() => {
  //   // edit: select by id => edit
  //   // delete : delete
  //   axios
  //     // put - post
  //     .get(`http://localhost:8080/select`)
  //     .then((res) => {
  //       setData(res.data);
  //       console.log(res.data);
  //     })
  //     .catch((error) => console.log(error));
  // }, [data]);

  const bodyAction = (todo) => {
    return (
      <>
        <Button
          icon="pi pi-user-edit"
          rounded
          text
          raised
          severity="danger"
          aria-label="Cancel"
          onClick={() => onClickEdit(todo)}
        />
        <Button
          icon="pi pi-times"
          rounded
          text
          raised
          severity="danger"
          aria-label="Cancel"
          onClick={() => onClikDelete(todo)}
        />
      </>
    );
  };

  const onClikDelete = (todo) => {
    setIdInput(todo.id);
    setNameInput(todo.name);
    setDateInput(todo.date);
    setStatusInput(todo.status);
    setVisibleDelete(true);
  };

  const onClickEdit = (todo) => {
    setIdInput(todo.id);
    setNameInput(todo.name);
    setDateInput(todo.date);
    setStatusInput(todo.status);
    setVisibleEdit(true);
  };

  const footerContentDelete = (todo) => (
    <div style={{ textAlign: "center" }}>
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleDelete(false)}
        className="p-button-text"
      />
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => deleteTodolist(todo)}
        autoFocus
      />
    </div>
  );

  const deleteTodolist = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .delete(`http://localhost:8080/delete/${idInput}`, headers)
      .catch((error) => console.log(error));
    setVisibleDelete(false);
  };

  const footerContentEdit = (todo) => (
    <div style={{ textAlign: "center" }}>
      Id:{" "}
      <InputText value={idInput} onChange={(e) => setIdInput(e.target.value)} />{" "}
      Name:{" "}
      <InputText
        value={nameInput}
        onChange={(e) => setNameInput(e.target.value)}
      />{" "}
      <hr />
      Date:{" "}
      <InputText
        value={dateInput}
        onChange={(e) => setDateInput(e.target.value)}
      />{" "}
      Status:{" "}
      <InputText
        value={statusInput}
        onChange={(e) => setStatusInput(e.target.value)}
      />{" "}
      <hr />
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleEdit(false)}
        className="p-button-text"
      />
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => updateTodolist(todo)}
        autoFocus
      />
    </div>
  );

  const updateTodolist = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .put(
        `http://localhost:8080/update`,
        JSON.stringify({
          id: idInput,
          name: nameInput,
          date: dateInput,
          status: statusInput,
        }),
        { headers }
      )
      .catch((error) => console.log(error));
    // setData(data);
    setVisibleEdit(false);
  };

  const InsertTodolist = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .post(
        `http://localhost:8080/insert`,
        JSON.stringify({
          name: nameInput,
          date: dateInput,
          status: statusInput,
        }),
        { headers }
      )
      .catch((error) => console.log(error));
    setVisibleInsert(false);
  };

  return (
    <div className="App">
      <header className="App-header">
        <div className="card">
          <DataTable value={data} tableStyle={{ minWidth: "50rem" }}>
            <Column field="id" header="Id"></Column>
            <Column field="name" header="Name"></Column>
            <Column field="date" header="Date"></Column>
            <Column field="status" header="Status"></Column>
            <Column header="Active" body={bodyAction}></Column>
          </DataTable>

          <Button
            label="Thêm mới"
            // icon="pi pi-times"
            onClick={() => setVisibleInsert(true)}
            className="p-button-text"
          />
        </div>

        {/* Delete */}
        <div className="card flex justify-content-center">
          <Dialog
            header="Bạn có chắc chắn xóa không ?"
            visible={visibleDelete}
            style={{ textAlign: "center" }}
            onHide={() => setVisibleDelete(false)}
            footer={footerContentDelete}
          ></Dialog>
        </div>

        {/* Edit */}
        <div className="card flex justify-content-center">
          <Dialog
            header="Nhap du lieu can thay doi"
            visible={visibleEdit}
            style={{ textAlign: "center" }}
            onHide={() => setVisibleEdit(false)}
            footer={footerContentEdit}
          ></Dialog>
        </div>

        {/* Insert */}
        <div className="card flex justify-content-center">
          <Dialog
            header="Nhap du lieu"
            visible={visibleInsert}
            style={{ textAlign: "center" }}
            onHide={() => setVisibleInsert(false)}
            // footer={footerContentEdit}
          >
            <div style={{ textAlign: "center" }}>
              Name:{" "}
              <InputText
                value={nameInput}
                onChange={(e) => setNameInput(e.target.value)}
              />{" "}
              Date:{" "}
              <InputText
                value={dateInput}
                onChange={(e) => setDateInput(e.target.value)}
              />{" "}
              Status:{" "}
              <InputText
                value={statusInput}
                onChange={(e) => setStatusInput(e.target.value)}
              />{" "}
              <hr />
              <Button
                label="No"
                icon="pi pi-times"
                onClick={() => setVisibleEdit(false)}
                className="p-button-text"
              />
              <Button
                label="Yes"
                icon="pi pi-check"
                onClick={() => InsertTodolist()}
                autoFocus
              />
            </div>
          </Dialog>
        </div>
      </header>
    </div>
  );
}

export default App;

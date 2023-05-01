import React, { useState, useEffect } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Button } from "primereact/button";
import "primeicons/primeicons.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import "primereact/resources/primereact.min.css";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import axios from "axios";

export default function Todolist({ todoList, onCheckBtnClick }) {
  const [visible, setVisible] = useState(false);
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [idInput, setIdInput] = useState("");
  const [nameInput, setNameInput] = useState("");
  const [datetimeInput, setDatetimeInput] = useState("");
  const [selectedTodo, setSelectedTodo] = useState({});
  const [data, setData] = useState({});

  useEffect(() => {
    // edit: select by id => edit
    // delete : delete
    axios
      // put - post
      .get(`http://localhost:8082/select`)
      .then((res) => {
        setData(res.data);
      })
      .catch((error) => console.log(error));
  }, [data]);

  const onClickEdit = (todo) => {
    console.log("onclick edit");
    setVisibleEdit(true);
    setIdInput(todo.id);
    setNameInput(todo.name);
    setDatetimeInput(todo.datetime);
    setSelectedTodo(todo);
    console.log(todo.id);
    console.log(todo.name);
    console.log(idInput);
    console.log(nameInput);
  };

  const updateTodo = (todo) => {
    console.log(idInput);
    console.log(nameInput);

    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .put(
        `http://localhost:8082/update`,
        JSON.stringify({ id: idInput, name: nameInput }),
        { headers }
      )
      .catch((error) => console.log(error));

    setData(data);
    console.log(data);
    setVisibleEdit(false);
  };

  const footerContent = (
    <div>
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisible(false)}
        className="p-button-text"
      />
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={(todo) => {
          setIdInput(todo.id);
          setNameInput(todo.name);
          setDatetimeInput(todo.datetime);
          setSelectedTodo(todo);
          axios
            .delete(`http://localhost:8082/deleteId/${idInput}`)
            .then((res) => {
              console.log(res.data);
              setData(res.data);
            })
            .catch((error) => console.log(error));

          setVisible(false);
        }}
        autoFocus
      />
    </div>
  );

  const onClickDelete = (todo) => {
    console.log("onclick delete");
    setVisible(true);
    setIdInput(todo.id);
    setNameInput(todo.name);
    setDatetimeInput(todo.datetime);
    setSelectedTodo(todo);
  };

  const actionBodyTemplate = (todo) => {
    return (
      <>
        <Button
          icon="pi pi-delete-left"
          rounded
          text
          aria-label="Filter"
          label="Edit"
          onClick={() => onClickEdit(todo)}
        ></Button>
        <Button
          icon="pi pi-file-edit"
          rounded
          text
          aria-label="Filter"
          label="Delete"
          onClick={() => onClickDelete(todo)}
          autoFocus
        ></Button>
      </>
    );
  };

  return (
    <>
      <DataTable value={data} tableStyle={{ minWidth: "50rem" }}>
        <Column field="id" header="Id"></Column>
        <Column field="name" header="Name"></Column>
        <Column field="datetime" header="Datetime"></Column>
        <Column field="status" header="Status"></Column>
        <Column header="Action" body={actionBodyTemplate}></Column>
      </DataTable>

      <Dialog
        visible={visibleEdit}
        style={{ width: "50vw" }}
        onHide={() => setVisibleEdit(false)}
      >
        ID:{" "}
        <InputText
          value={idInput}
          onChange={(e) => setIdInput(e.target.value)}
        />
        Tên:{" "}
        <InputText
          value={nameInput}
          onChange={(e) => setNameInput(e.target.value)}
        />
        <Button
          icon="pi pi-file-edit"
          label="Update"
          onClick={updateTodo}
        ></Button>
      </Dialog>

      <Dialog
        header="Header"
        visible={visible}
        style={{ width: "50vw" }}
        onHide={() => setVisible(false)}
        footer={footerContent}
      ></Dialog>
    </>
  );
}

//json
// const [data, setData] = useState([
//   {
//     id: 1,
//     name: "Name 1",
//     datetime: "2023-04-12 12:10",
//     status: "Done",
//   },
//   {
//     id: 2,
//     name: "Wash dish",
//     datetime: "2023-04-12 2:10",
//     status: "Doing",
//   },
// ]);

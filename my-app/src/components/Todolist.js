import React, { useState } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Button } from "primereact/button";
import "primeicons/primeicons.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import "primereact/resources/primereact.min.css";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";

export default function Todolist({ todoList, onCheckBtnClick }) {
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [nameInput, setNameInput] = useState("");
  const [datetimeInput, setDatetimeInput] = useState("");
  const [selectedTodo, setSelectedTodo] = useState({});

  const [data, setData] = useState([
    {
      id: 1,
      name: "Name 1",
      datetime: "2023-04-12 12:10",
      status: "Done",
    },
    {
      id: 2,
      name: "Wash dish",
      datetime: "2023-04-12 2:10",
      status: "Doing",
    },
  ]);

  const onClickEdit = (todo) => {
    console.log("onclick edit");
    setVisibleEdit(true);
    setNameInput(todo.name);
    setDatetimeInput(todo.datetime);
    setSelectedTodo(todo);
  };

  const updateTodo = () => {
    data.forEach((element) => {
      if (element.id === selectedTodo.id) {
        element.name = nameInput;
        element.datetime = datetimeInput;
      }
    });
    setData(data);
    console.log(data);
    setVisibleEdit(false);
  };

  const actionBodyTemplate = (todo) => {
    return (
      <>
        <Button
          icon="pi-delete-left"
          rounded
          text
          aria-label="Filter"
          label="Edit"
          onClick={() => onClickEdit(todo)}
        ></Button>
        <Button
          icon="pi-file-edit"
          rounded
          text
          aria-label="Filter"
          label="Delete"
        ></Button>
      </>
    );
  };

  return (
    <>
      <DataTable value={data} tableStyle={{ minWidth: "50rem" }}>
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
        Tên việc:{" "}
        <InputText
          value={nameInput}
          onChange={(e) => setNameInput(e.target.value)}
        />
        Thời gian làm:{" "}
        <InputText
          value={datetimeInput}
          onChange={(e) => setDatetimeInput(e.target.value)}
        />
        <Button
          icon="pi-file-edit"
          label="Update"
          onClick={updateTodo}
        ></Button>
      </Dialog>
    </>
  );
}

//json

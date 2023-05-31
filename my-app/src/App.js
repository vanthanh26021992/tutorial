import Todolist from "./components/Todolist";
import { useCallback, useEffect, useState } from "react";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import axios from "axios";

const TODO_APP_STORAGE_KEY = "TODO_APP";

function App() {
  // props: truyền dữ liệu từ bên ngoài vào component
  // html, css, javascript:
  const [todoList, setTodoList] = useState([]);
  const [textInputId, setTextInputId] = useState("");
  const [textInputName, setTextInputName] = useState("");

  useEffect(() => {
    const storagedTodoList = localStorage.getItem(TODO_APP_STORAGE_KEY);
    if (storagedTodoList) {
      setTodoList(JSON.parse(storagedTodoList));
    }
  }, []);

  useEffect(() => {
    localStorage.setItem(TODO_APP_STORAGE_KEY, JSON.stringify(todoList));
  }, [todoList]);

  const onAddBtnClick = useCallback(
    (e) => {
      // Them text input vao danh sach todoLish
      // setTodoList([
      //   { id: textInputId, name: textInputName, isCompleted: false },
      //   ...todoList,
      // ]);

      setTextInputId();
      setTextInputName("");
      console.log(textInputId);
      console.log(textInputName);
      const headers = { "Content-Type": "application/json;charset=utf-8" };
      axios
        .post(
          `http://localhost:8082/insert`,
          JSON.stringify({ id: textInputId, name: textInputName || "" }),
          { headers }
        )
        .catch((error) => console.log(error));
    },
    [textInputId, textInputName]
  );

  const onCheckBtnClick = useCallback((id) => {
    setTodoList((prevState) =>
      prevState.map((todo) =>
        todo.id === id ? { ...todo, isCompleted: true } : todo
      )
    );
  }, []);

  return (
    <>
      <h3>Danh sách cần làm</h3>
      ID:{" "}
      <InputText
        value={textInputId || ""}
        onChange={(e) => setTextInputId(e.target.value)}
      />
      Ten:{" "}
      <InputText
        value={textInputName || ""}
        onChange={(e) => setTextInputName(e.target.value)}
      />
      <Button label="Them" onClick={onAddBtnClick} />
      <Todolist todoList={todoList} onCheckBtnClick={onCheckBtnClick} />
    </>
  );
}

export default App;

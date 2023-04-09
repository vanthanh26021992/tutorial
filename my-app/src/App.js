import Todolist from "./components/Todolist";

import { useCallback, useEffect, useState } from "react";
import { v4} from 'uuid';
import "primereact/resources/themes/lara-light-indigo/theme.css";   
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";   
import { Button } from 'primereact/button'; 
import { InputText } from 'primereact/inputtext';
import ComponentDemo from "./components/ComponentDemo";

const TODO_APP_STORAGE_KEY = 'TODO_APP';

function App() {
  // props: truyền dữ liệu từ bên ngoài vào component
  // html, css, javascript: 
  const [todoList, setTodoList] = useState([]);
  const [textInput, setTextInput] = useState("");

  

  useEffect(() =>{
    const storagedTodoList = localStorage.getItem(TODO_APP_STORAGE_KEY);
    if (storagedTodoList) {
      setTodoList(JSON.parse(storagedTodoList));
    }
  }, []);
  
  useEffect(() => {
    localStorage.setItem(TODO_APP_STORAGE_KEY, JSON.stringify(todoList));
  },[todoList]);

  const onTextInputChange = useCallback((e) => {
    setTextInput(e.target.value);
  }, []);

  const onAddBtnClick = useCallback((e) => {
    // Them text input vao danh sach todoLish
    setTodoList([
      {id:v4(), name: textInput, isCompleted: false},
      ...todoList,
    ]);
    setTextInput("");
    console.log(todoList);
  },[textInput, todoList]
  );

const onCheckBtnClick = useCallback((id) =>{
  setTodoList((prevState) => prevState.map(todo => 
    todo.id ===id ? {...todo, isCompleted: true} : todo));
}, []);
  return (
    <>
      <h3>Danh sách cần làm</h3>
      Tên việc: <InputText value={textInput} onChange={(e) => setTextInput(e.target.value)} />
      Thời gian làm: <InputText value={textInput} onChange={(e) => setTextInput(e.target.value)} />

       <Button label="Them" onClick={onAddBtnClick}/>
      <Todolist todoList={todoList} onCheckBtnClick={onCheckBtnClick} />
      <ComponentDemo />
    </>
  );
}

export default App;

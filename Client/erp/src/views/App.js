import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React from "react";
import MenuComponent from "../components/menu/menu";
import "./App.css";

function App(props) {
  return (
    <div className="App" style={({ height: "100vh" }, { display: "flex" })}>
      <MenuComponent />
    </div>
  );
}

export default App;

// login account xong nhan F5 thi ko giu nguyen tk ma lai ra trang login

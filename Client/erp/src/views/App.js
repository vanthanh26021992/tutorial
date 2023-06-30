import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useEffect, useState } from "react";
import { Route, Routes, useNavigate } from "react-router-dom";
import Login from "../components/Login";
import MenuComponent from "../components/menu/menu";
import "./App.css";

function App(props) {
  const navigate = useNavigate();
  const [user, setUser] = useState(null);

  useEffect(() => {
    let user = localStorage.getItem("account");
    if (user) setUser(JSON.parse(user));
    else navigate("/login");
  }, [navigate]);

  return (
    <Routes>
      <Route path="*" element={user ? <MenuComponent /> : <Login />} />
      <Route path="home" element={<MenuComponent />} />
      {/* <Route path="*" element={<Navigate to="/" />} /> */}
    </Routes>
  );
}

export default App;

// login account xong nhan F5 thi ko giu nguyen tk ma lai ra trang login

import { Menu } from "primereact/menu";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Account from "../Account";
import Employee from "../employee/Employee";
import Login from "../Login";
import Supplier from "../supplier/supplier";

export default function MenuComponent() {
  let items = [
    { label: "Login", icon: "pi pi-fw pi-plus", url: "/Login" },
    { label: "Account", icon: "pi pi-fw pi-plus", url: "/account" },
    { label: "Employee", icon: "pi pi-fw pi-trash", url: "/employee" },
    { label: "Supplier", icon: "pi pi-fw pi-trash", url: "/supplier" },
  ];

  return (
    <>
      <Menu model={items} />
      <BrowserRouter>
        <div className="menu">
          <Routes>
            <Route path="/Login" element={<Login />} />
            <Route path="/account" element={<Account />} />
            <Route path="/employee" element={<Employee />} />
            <Route path="/supplier" element={<Supplier />} />
          </Routes>
        </div>
      </BrowserRouter>
    </>
  );
}

import { Menu } from "primereact/menu";
import { Route, Routes } from "react-router-dom";
import Account from "../Account";
import Employee from "../employee/Employee";
import Product from "../product/product";
import Supplier from "../supplier/supplier";

export default function MenuComponent() {
  const items = [
    { label: "Account", icon: "pi pi-fw pi-plus", url: "/account" },
    { label: "Employee", icon: "pi pi-fw pi-trash", url: "/employee" },
    { label: "Supplier", icon: "pi pi-fw pi-trash", url: "/supplier" },
    { label: "Product", icon: "pi pi-fw pi-trash", url: "/product" },
  ];

  return (
    <>
      <Menu model={items} />

      <div className="menu">
        <Routes>
          <Route path="/account" element={<Account />} />
          <Route path="/employee" element={<Employee />} />
          <Route path="/supplier" element={<Supplier />} />
          <Route path="/product" element={<Product />} />
        </Routes>
      </div>
    </>
  );
}

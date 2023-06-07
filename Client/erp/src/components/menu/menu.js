import { Menu } from 'primereact/menu';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Account from '../Account';
import Employee from '../employee/Employee';

export default function MenuComponent() {
  let items = [
      {label: 'Account', icon: 'pi pi-fw pi-plus', url: "/account"},
      {label: 'Employee', icon: 'pi pi-fw pi-trash', url: "/employee"},
      {label: 'Supplier', icon: 'pi pi-fw pi-trash', url: "/supplier"},
  ];

  return (
    <>
      <Menu model={items} />
      <BrowserRouter>
        <Routes>
            <Route path='/account' element={<Account/>}/>
            <Route path="/employee" element={<Employee />} />
            <Route path="/supplier" element={<Employee />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}
   
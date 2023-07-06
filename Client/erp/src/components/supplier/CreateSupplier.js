import axios from "axios";
import { Button } from "primereact/button";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import { CONFIG } from "../../ultils/constants";

function CreateSupplier({ getSupplier }) {
  const [visibleSignUpEmloyee, setVisibleSignUpSupplier] = useState(false);
  const [supplierCode, setSupplierCode] = useState("");
  const [supplierName, setSupplierName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");

  const onClickSignUpSupplier = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .post(
        `${CONFIG.SERVER}/supplier/insert`,
        JSON.stringify({
          supplierCode: supplierCode,
          supplierName: supplierName,
          email: email,
          phone: phone,
          address: address,
        }),
        { headers }
      )
      .then((response) => {
        getSupplier();
      })
      .catch((error) => console.log(error));
    setVisibleSignUpSupplier(false);
    //}
  };

  return (
    <div className="App">
      <header>
        <Button
          label="Create new supplier"
          text
          onClick={() => setVisibleSignUpSupplier(true)}
        />
        <div className=" flex justify-content-center">
          <Dialog
            header="Create Employee"
            style={{ width: "50vw", textAlign: "center" }}
            visible={visibleSignUpEmloyee}
            onHide={() => setVisibleSignUpSupplier(false)}
          >
            <div className="">
              <div className="">
                <div className="flex flex-column gap-2">
                  <div className="in-block">
                    <label className="labelInputEmployee">SupplierCode: </label>{" "}
                    <br />
                    <InputText
                      required
                      minLength={7}
                      aria-describedby="username-help"
                      onChange={(e) => setSupplierCode(e.target.value)}
                    />
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">SupplierName: </label>{" "}
                    <br />
                    <InputText
                      // id="password"
                      required
                      minLength={7}
                      aria-describedby="password-help"
                      onChange={(e) => setSupplierName(e.target.value)}
                    />
                  </div>

                  <div className="in-block">
                    <label className="labelInputEmployee">Address: </label>{" "}
                    <br />
                    <InputText
                      id="rePassword"
                      required
                      minLength={7}
                      aria-describedby="rePassword-help"
                      onChange={(e) => setAddress(e.target.value)}
                    />
                  </div>
                  <div className="in-block">
                    <label className="labelInputEmployee">Email: </label> <br />
                    <InputText
                      id="fullname"
                      aria-describedby="fullname-help"
                      onChange={(e) => setEmail(e.target.value)}
                    />
                    <small id="fullname-help"></small>
                  </div>
                </div>

                <div className="flex flex-column gap-2">
                  <div className="in-block">
                    <label className="labelInputEmployee">Phone: </label> <br />
                    <InputText
                      id="phone"
                      aria-describedby="phone-help"
                      onChange={(e) => setPhone(e.target.value)}
                    />
                    <small id="phone-help"></small>
                  </div>
                </div>
              </div>

              <div className="center">
                <Button
                  label="Yes"
                  icon="pi pi-check"
                  type="submit"
                  onClick={onClickSignUpSupplier}
                />
                <Button
                  label="No"
                  icon="pi pi-times"
                  onClick={() => setVisibleSignUpSupplier(false)}
                  className="p-button-text"
                />
              </div>
            </div>
          </Dialog>
        </div>
      </header>
    </div>
  );
}

export default CreateSupplier;

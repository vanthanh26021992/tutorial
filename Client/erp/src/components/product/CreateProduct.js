import axios from "axios";
import { Button } from "primereact/button";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import { CONFIG } from "../../ultils/constants";

function CreateProduct({ getProduct, getAccounts }) {
  const [visibleSignUpProduct, setVisibleSignUpProduct] = useState(false);
  const [productCode, setProductCode] = useState("");
  const [productName, setProductName] = useState("");
  const [unit, setunit] = useState("");

  const onClickSignUpProduct = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .post(
        `${CONFIG.SERVER}/product/insert`,
        JSON.stringify({
          productCode: productCode,
          productName: productName,
          unit: unit,
        }),
        { headers }
      )
      .then((response) => {
        getProduct();
      })
      .catch((error) => console.log(error));
    setVisibleSignUpProduct(false);
    //}
  };

  return (
    <div className="App">
      <header>
        <Button
          label="Create new products"
          text
          onClick={() => setVisibleSignUpProduct(true)}
        />
        <div className=" flex justify-content-center">
          <Dialog
            header="Create Product"
            style={{ width: "50vw", textAlign: "center" }}
            visible={visibleSignUpProduct}
            onHide={() => setVisibleSignUpProduct(false)}
          >
            <div className="">
              <div className="">
                <div className="flex flex-column gap-2">
                  <div className="in-block-product">
                    <label className="labelInputProduct">productCode: </label>{" "}
                    <br />
                    <InputText
                      required
                      minLength={7}
                      aria-describedby="productCode-help"
                      onChange={(e) => setProductCode(e.target.value)}
                    />
                  </div>
                  <div className="in-block-product">
                    <label className="labelInputProduct">productName: </label>{" "}
                    <br />
                    <InputText
                      // id="productName"
                      type="productName"
                      required
                      minLength={7}
                      aria-describedby="productName-help"
                      onChange={(e) => setProductName(e.target.value)}
                    />
                  </div>

                  <div className="in-block-product">
                    <label className="labelInputProduct">unit: </label> <br />
                    <InputText
                      id="unit"
                      aria-describedby="unit-help"
                      onChange={(e) => setunit(e.target.value)}
                    />
                    <small id="unit-help"></small>
                  </div>
                </div>
              </div>

              <div className="center">
                <Button
                  label="Yes"
                  icon="pi pi-check"
                  type="submit"
                  onClick={onClickSignUpProduct}
                />
                <Button
                  label="No"
                  icon="pi pi-times"
                  onClick={() => setVisibleSignUpProduct(false)}
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

export default CreateProduct;

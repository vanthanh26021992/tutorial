import axios from "axios";
import { Button } from "primereact/button";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import { CONFIG } from "../../ultils/constants";

function CreateInventory({ getinventory, getAccounts }) {
  const [visibleSignUpinventory, setVisibleSignUpInventory] = useState(false);
  const [inventoryCode, setInventoryCode] = useState("");
  const [inventoryName, setInventoryName] = useState("");
  const [unit, setunit] = useState("");
  const [quantity, setQuantity] = useState();
  const [priceBuy, setPriceBuy] = useState();
  const [priceTotal, setPriceTotal] = useState();

  const onClickSignUpInventory = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .post(
        `${CONFIG.SERVER}/inventory/insert`,
        JSON.stringify({
          inventoryCode: inventoryCode,
          inventoryName: inventoryName,
          unit: unit,
          quantity: quantity,
          priceBuy: priceBuy,
          priceTotal: priceTotal,
        }),
        { headers }
      )
      .then((response) => {
        getinventory();
      })
      .catch((error) => console.log(error));
    setVisibleSignUpInventory(false);
    //}
  };

  return (
    <div className="App">
      <header>
        <Button
          label="Create new inventorys"
          text
          onClick={() => setVisibleSignUpInventory(true)}
        />
        <div className=" flex justify-content-center">
          <Dialog
            header="Create inventory"
            style={{ width: "50vw", textAlign: "center" }}
            visible={visibleSignUpinventory}
            onHide={() => setVisibleSignUpInventory(false)}
          >
            <div className="">
              <div className="">
                <div className="flex flex-column gap-2">
                  <div className="in-block-inventory">
                    <label className="labelInputinventory">
                      InventoryCode:{" "}
                    </label>{" "}
                    <br />
                    <InputText
                      required
                      minLength={7}
                      aria-describedby="inventoryCode-help"
                      onChange={(e) => setInventoryCode(e.target.value)}
                    />
                  </div>
                  <div className="in-block-inventory">
                    <label className="labelInputinventory">
                      InventoryName:{" "}
                    </label>{" "}
                    <br />
                    <InputText
                      // id="inventoryName"
                      type="inventoryName"
                      required
                      minLength={7}
                      aria-describedby="inventoryName-help"
                      onChange={(e) => setInventoryName(e.target.value)}
                    />
                  </div>

                  <div className="in-block-inventory">
                    <label className="labelInputinventory">Unit: </label> <br />
                    <InputText
                      id="unit"
                      aria-describedby="unit-help"
                      onChange={(e) => setunit(e.target.value)}
                    />
                    <small id="unit-help"></small>
                  </div>
                </div>
                <div className="flex flex-column gap-2">
                  <div className="in-block-inventory">
                    <label className="labelInputinventory">Quantity: </label>{" "}
                    <br />
                    <InputText
                      required
                      aria-describedby="inventoryCode-help"
                      onChange={(e) => setQuantity(e.target.value)}
                    />
                  </div>
                  <div className="in-block-inventory">
                    <label className="labelInputinventory">PriceBuy: </label>{" "}
                    <br />
                    <InputText
                      type="inventoryName"
                      required
                      aria-describedby="inventoryName-help"
                      onChange={(e) => setPriceBuy(e.target.value)}
                    />
                  </div>

                  <div className="in-block-inventory">
                    <label className="labelInputinventory">PriceTotal: </label>{" "}
                    <br />
                    <InputText
                      id="priceTotal"
                      aria-describedby="priceTotal-help"
                      onChange={(e) => setPriceTotal(e.target.value)}
                    />
                  </div>
                </div>
              </div>

              <div className="center">
                <Button
                  label="Yes"
                  icon="pi pi-check"
                  type="submit"
                  onClick={onClickSignUpInventory}
                />
                <Button
                  label="No"
                  icon="pi pi-times"
                  onClick={() => setVisibleSignUpInventory(false)}
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

export default CreateInventory;

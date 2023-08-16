import axios from "axios";
import { CONFIG } from "../ultils/constants";

const InventoryService = {
  async searchInventoryByName(name) {
    let data;
    await axios
      .get(`${CONFIG.SERVER}/Inventory/search-by-name`, {
        params: { name: name },
      })
      .then((res) => (data = res.data))
      .catch((err) => console.log(err));
    return data;
  },
};

export default InventoryService;

import React from 'react'
// import Button from '@atlaskit/button';
// import CheckIcon from '@atlaskit/icon/glyph/check';
import { Button } from 'primereact/button';  



export default function Todo({todo, onCheckBtnClick}) {
  return (
    <Button label={todo.name}  icon="pi pi-pencil" iconPos="right"/>
  );
}
// có một bảng danh sách việc cần làm
/*
bảng có các cột: tên việc, thời gian làm, trạng thái(todo, done, doing), action (thao tác: sửa, xóa)
sửa: click vào sửa, hiển thị một popup, trong popup này sửa được thông tin của tên việc vào thời gian làm
xóa: hiển thị một popup hỏi xác nhận có muốn xóa hay không: OK, CANCEL
*/

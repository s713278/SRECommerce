function RowItem(props) {
   
 return(
    <tr>
    <th scope='row'>{props.id}</th>
    <td>{props.name} </td>
    <td>{props.price}</td>
    </tr>
 )
}
export default RowItem;
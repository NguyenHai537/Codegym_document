import { useState,useEffect} from "react";
import { Form, useParams ,useNavigate} from "react-router-dom";

export default function Edit(){
  let { editID } = useParams();
  const  navigate = useNavigate();
  const[user,setUser] = useState({
    id:Number.parseInt(editID - 1),
    name:"",
    email:"" })
    const [users,setUsers] = useState([]);

  useEffect(() =>{
     const UserList = [...(JSON.parse(localStorage.getItem('users')))];
     setUsers(UserList);
     const userHT = UserList.find((u) => parseInt(u.id)=== parseInt(editID));
     setUser(userHT)
    },[]);

    const handlerChange = (e) =>{
      let name = e.target.name;
      let value = e.target.value;
      const updatedUser = ({ ...user, [name]: value });
        setUser(updatedUser)
    }


    const handleSubmit = () =>{
        if(user.name && user.email) {
           const UserList = users;
            UserList.splice(users.indexOf(UserList.find((u) => parseInt(u.id)=== parseInt(editID))),1,user)
            localStorage.setItem("users",JSON.stringify(UserList))
            alert("Thanh Cong")
            navigate(`/`)
        }else{
          alert("That Bai")
          navigate(`/`);
        }
      
        
    }
      return (
    <div>
            <h2>User Update</h2>          
           <div>
                <input name="id" hidden={user.id} />
              </div>
              <div>
                <label>Name: </label>
                <input  name="name"  value={user.name}  onChange={handlerChange} />
              </div>
              <div>
                <label>Email: </label>
                <input name="email" value={user.email} onChange={handlerChange}/>
              </div>
              <button onClick={handleSubmit}>Submit</button>
        </div>
  );
}

import axios from "axios";
import {  useEffect, useState } from "react";

export default function GetUsers(){
    const [users,setUsers] = useState([]);
    const [loading,setLoading] = useState(false);   

    useEffect(()=>{
        setLoading(true);
        getUsers()
        .then(res =>{
            setUsers(res.data);
        })
        .catch(err =>{
            throw err;
        })
        .finally(()=>{
            setLoading(false);
        });
      
    },[])

    function getUsers(){
        return new Promise((resolve,reject) =>{
            setTimeout(()=>{
                axios
                .get(`http://localhost:3001/api/users`)
                .then(res => {
                  resolve(res);
                })
                .catch(error => {
                    reject(error);
                });
            },3000);
        });  
    };
 
    // const handleCreate = () => {
    // window.location.href = "/user/add";
    // };

    if (loading) return <p>loading...</p>;

        return (
          
          <div>
            <h1>Users</h1>   
              {users.map(user => (
                 <li key={user.id}> {user.name} </li>
              ))}
    
          </div>
        );
    }

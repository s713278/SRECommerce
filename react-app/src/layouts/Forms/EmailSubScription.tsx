import React, { FormEvent, useEffect, useState } from "react";
import axios from 'axios';
export const EmailSubScription = () => {

    const [email,setEmail] = useState('');
    const [valid,setValid] = useState(false);


    const validateEmail=(event: { target: { value: any; }; })=>{
        alert(event.target.value);
      if(event.target.value){
        setValid(true);
      }else{
        setValid(false);
      }
    }    

    const handleSubmit = async () => {
      try {
        const response = await axios.post('/api/subscribe', { email });
        console.log(response.data);
      } catch (error) {
        console.error(error);
      }
    };


    return(   
        <div>
            <form onSubmit={handleSubmit} method="POST">
                    <span>Email : <input type="text" name="email" placeholder="Enter Email.." value={email} onChange={(e) => setEmail(e.target.value)}/></span>
                    <span><button type="submit">Subscribe</button></span>
            </form>
        </div>
    );
}

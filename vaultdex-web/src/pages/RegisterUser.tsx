import React from "react";
import TextInput from "../components/input/TextInput";
import Button from "../components/button/Button";
import { useRegisterUser } from "../hooks/useUsers";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

const RegisterUser = () => {
    const [username, setUsername] = React.useState("");
    const [email, setEmail] = React.useState("");
    const [password, setPassword] = React.useState("");
    const registerUserMutation = useRegisterUser();
    const navigate = useNavigate();

    const handleRegister = () => {
        if (username.trim() === "" || email.trim() === "" || password.trim() === "") {
            toast.warn("Please fill in all fields.");
            return;
        }

        registerUserMutation.mutate(
            { username, email, password },
            {
                onSuccess: () => {
                    toast.success("User registered successfully!");
                    setUsername("");
                    setEmail("");
                    setPassword("");
                    navigate("/login");
                },
                onError: () => {
                    toast.error("Registration failed. Please try again.");
                }
            }
        );
    };

    return (
        <div>
            <h1>Register User</h1>
            <TextInput label="Username" name="username" value={username} onChange={(e) => setUsername(e.target.value)} />
            <TextInput label="Email" name="email" value={email} onChange={(e) => setEmail(e.target.value)} />
            <TextInput label="Password" name="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <Button label="Register" onClick={handleRegister} />
        </div>
    );
};

export default RegisterUser;
import React from "react";
import TextInput from "../components/input/TextInput";
import Button from "../components/button/Button";
import { useLoginUser } from "../hooks/useUsers";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

const Login = () => {

    const [username, setUsername] = React.useState("");
    const [password, setPassword] = React.useState("");
    const loginUserMutation = useLoginUser();
    const navigate = useNavigate();

    const handleLogin = () => {
        if (username.trim() === "" || password.trim() === "") {
            toast.warn("Please fill in all fields.");
            return;
        }

        loginUserMutation.mutate(
            { username, password },
            {
                onSuccess: () => {
                    localStorage.setItem("isAuthenticated", "true");
                    toast.success("Login successful!");
                    navigate("/dashboard");
                },
                onError: () => {
                    toast.error("Login failed. Please check your credentials and try again.");
                }
            }
        );
    };

    return (
        <div>
            <h1>Login</h1>
            <TextInput label="Username" name="username" value={username} onChange={(e) => setUsername(e.target.value)} />
            <TextInput label="Password" name="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <Button label="Submit" onClick={handleLogin} />
        </div>
    );

}

export default Login;
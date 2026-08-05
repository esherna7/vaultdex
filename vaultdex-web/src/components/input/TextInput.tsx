import React from "react";

interface ITextInputProps {
    label: string;
    name: string;
    value: string;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

const TextInput = ({ label, name, value, onChange }: ITextInputProps) => {
    return (
        <div className="grid grid-cols-2">
            <label htmlFor={name}>{label}</label>
            <input
                type={name === "password" ? "password" : "text"}
                id={name}
                name={name}
                value={value}
                onChange={onChange}
                className="w-48"
                style={{ display: 'flex', marginBottom: '10px', border: 'solid 1px black', borderRadius: '4px', padding: '5px' }}
            />
        </div>
    )
}

export default TextInput;
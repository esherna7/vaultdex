import React from 'react';

const Button = ({ children, onClick, className }: { children: React.ReactNode; onClick?: () => void; className?: string }) => {
    return (
        <button
            onClick={onClick}
            className={`px-4 py-2 rounded-md text-white bg-blue-500 hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-400 ${className}`}
        >
            {children}
        </button>
    );
};

export default Button;